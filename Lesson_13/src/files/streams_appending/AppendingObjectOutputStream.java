package files.streams_appending;

import java.io.*;

class AppendingObjectOutputStream extends ObjectOutputStream {


    private static int i = 0;

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // Do not write a header to prevent corruption in append mode
        i++;
        System.out.println("Resetted: " + i);

//        reset();
    }
}

