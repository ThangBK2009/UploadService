package com.visc.uploadservice;

import com.visc.uploadservice.http.HttpConnection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Implements a binary file upload task.
 *
 * @author cankov
 * @author gotev (Aleksandar Gotev)
 */
public class BinaryUploadTask extends HttpUploadTask {

    @Override
    protected long getBodyLength() throws UnsupportedEncodingException {
        return params.getFiles().get(0).length();
    }

    @Override
    protected void writeBody(HttpConnection connection) throws IOException {
        writeStream(params.getFiles().get(0).getStream());
    }

    @Override
    protected void onSuccessfulUpload() {
        addSuccessfullyUploadedFile(params.getFiles().get(0).getAbsolutePath());
    }
}
