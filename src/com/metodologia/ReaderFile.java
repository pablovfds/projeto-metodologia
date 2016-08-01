package com.metodologia;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReaderFile {

    private String path;
    private StringBuilder text;
    private final String lineBreak = System.getProperty("line.separator");

    public ReaderFile(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] readerLines() throws IOException {
        if(text != null){
            return text.toString().split(lineBreak);
        }
        RandomAccessFile aFile = new RandomAccessFile(getPath(), "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(72000);

        int bytesRead = inChannel.read(buf);
        text = new StringBuilder();
        while (bytesRead != -1) {
            buf.flip();

            while (buf.hasRemaining()) {
                char caractere = (char) buf.get();
                text.append(caractere);
            }
            text.deleteCharAt(text.length() - 1);
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
        return text.toString().split(lineBreak);
    }

}
