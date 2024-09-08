package com.linguish.Interface;

import com.linguish.Entity.Progress;

import java.io.IOException;
import java.util.List;

public interface IProgressService {

    List<Progress> getProgress();

    Progress getProgressById(Long id);

    String saveProgress(Progress progress) throws IOException;

    void updateProgressById(Long id, Progress progress) throws IOException;

    void deleteProgressById(Long id) throws IOException;
}
