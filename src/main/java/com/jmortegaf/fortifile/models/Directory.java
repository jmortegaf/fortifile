package com.jmortegaf.fortifile.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "directory")
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parent_folder_id")
    private Folder parent;
    @OneToMany(mappedBy = "parent")
    private List<Folder> subfolder;
    @OneToMany(mappedBy = "folder")
    private List<File> files;

}
