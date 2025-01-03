package com.jmortegaf.fortifile.validators.files.path;

import com.jmortegaf.fortifile.exceptions.NewFileErrorException;

import java.io.File;

public class FilePathValidator implements NewFileValidator<String>{

    @Override
    public void validate(String path) {
        File uploadFolder = new File(path);
        if(!uploadFolder.exists())
            throw new NewFileErrorException("Path doesn't exist");
    }
}
