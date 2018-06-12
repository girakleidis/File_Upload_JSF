/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

/**
 *
 * @author george
 */
@ManagedBean
@SessionScoped

public class fileUpload {

    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    private String link = "/tmp/";

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void upload() throws IOException {
        if (file != null) {
            String name = file.getSubmittedFileName();
            String type = file.getContentType();
            long size = file.getSize();
            InputStream content = file.getInputStream();

            Files.copy(content, new File(link, name).toPath());

        }

    }
}
