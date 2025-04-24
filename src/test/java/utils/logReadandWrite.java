package utils;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class logReadandWrite {  // Class name changed to exact requested casing
    private static logReadandWrite instance = null;
    private final SerialPort serialPort;
    private volatile boolean running = false;
    private final Path logFilePath = Path.of("Serial_log.log");
    private Thread readThread;
    private final BlockingQueue<String> dataQueue = new LinkedBlockingQueue<>();
    private Thread processingThread;

    public logReadandWrite(String portName) {  // Constructor name changed
        serialPort = new SerialPort(portName);
    }

    public static logReadandWrite getInstance(String portName) {  // Return type changed
        if (instance == null) {
            instance = new logReadandWrite(portName);
        }
        return instance;
    }

    // Rest of the methods remain identical to previous implementation
    public synchronized void openPort() {
        try {
            if (!serialPort.isOpened()) {
                clearLogFile();
                serialPort.openPort();
                serialPort.setParams(
                    SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE
                );
                serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | 
                                           SerialPort.FLOWCONTROL_RTSCTS_OUT);
                running = true;
                startProcessingThread();
                startReadThread();
                System.out.println("Port opened successfully");
            }
        } catch (SerialPortException ex) {
            System.out.println("Error opening port: " + ex.getMessage());
        }
    }

    private void clearLogFile() {
        try {
            Files.writeString(logFilePath, "", 
                StandardOpenOption.CREATE, 
                StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Log file cleared for new session");
        } catch (IOException e) {
            System.out.println("Error clearing log file: " + e.getMessage());
        }
    }

    private void startReadThread() {
        readThread = new Thread(() -> {
            byte[] buffer = new byte[1024];
            while (running) {
                try {
                    if (serialPort.getInputBufferBytesCount() > 0) {
                        byte[] receivedBytes = serialPort.readBytes();
                        if (receivedBytes != null && receivedBytes.length > 0) {
                            String data = new String(receivedBytes).trim();
                            dataQueue.put(data);
                        }
                    }
                    Thread.sleep(10);
                } catch (SerialPortException | InterruptedException e) {
                    if (running) {
                        System.out.println("Read error: " + e.getMessage());
                    }
                }
            }
        });
        readThread.start();
    }

    private void startProcessingThread() {
        processingThread = new Thread(() -> {
            while (running || !dataQueue.isEmpty()) {
                try {
                    String data = dataQueue.take();
                    Files.writeString(logFilePath, 
                                     data + System.lineSeparator(),
                                     StandardOpenOption.CREATE, 
                                     StandardOpenOption.APPEND);
                    //System.out.println("Received: " + data);
                } catch (InterruptedException | IOException e) {
                    if (running) {
                        System.out.println("Processing error: " + e.getMessage());
                    }
                }
            }
        });
        processingThread.start();
    }

    public synchronized void write(String comment) {
        try {
            if (serialPort.isOpened()) {
                serialPort.writeBytes(comment.getBytes());
                System.out.println("Sent: " + comment);
                Thread.sleep(50);
            }
        } catch (SerialPortException | InterruptedException ex) {
            System.out.println("Write error: " + ex.getMessage());
        }
    }

    public synchronized void closePort() {
        running = false;
        try {
            if (serialPort.isOpened()) {
                serialPort.closePort();
            }
            if (readThread != null) {
                readThread.interrupt();
                readThread.join(1000);
            }
            if (processingThread != null) {
                processingThread.interrupt();
                processingThread.join(1000);
            }
            System.out.println("Port closed successfully");
        } catch (SerialPortException | InterruptedException ex) {
            System.out.println("Close error: " + ex.getMessage());
        }
    }
}