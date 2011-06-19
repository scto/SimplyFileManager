package lubenets.vladyslav.file.manager.file.filter;

import java.io.File;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import lubenets.vladyslav.file.manager.main.ViewModel;

public class FileFilter{

    public void filterThis(ViewModel viewModel) {
        String input = "";

        input = viewModel.jFilter.getText();
        SortedSet<String> folders = new TreeSet<String>();
        SortedSet<String> files = new TreeSet<String>();

        if (input.length() != 0) {
            File fileType = new File(viewModel.getApplication().getFileModel().path);
            File[] newFileList = fileType.listFiles();
            for (int k = 0; k < newFileList.length; k++) {

                if (newFileList[k].isFile()) {
                    if (newFileList[k].getName().contains(input)) {
                        files.add(newFileList[k].getName());
                    }

                } else {
                    if (newFileList[k].getName().contains(input)) {
                        folders.add(newFileList[k].getName());
                    }

                }

            }
            viewModel.getApplication().getViewModel().lm.clear();
            viewModel.getApplication().getViewModel().lm.addElement("..");

        } else {
            viewModel.getApplication().getViewModel().lm.clear();
            viewModel.getApplication().getFileModel().displayFilesFromAPath();
        }

        Iterator<String> iteratorForFolders = folders.iterator();
        Iterator<String> iteratorForFiles = files.iterator();

        for (int i = 0; i < folders.size(); i++) {
            if (iteratorForFolders.hasNext()) {
                viewModel.getApplication().getViewModel().lm.addElement(iteratorForFolders.next());
            }
        }

        for (int i = 0; i < files.size(); i++) {
            if (iteratorForFiles.hasNext()) {
                viewModel.getApplication().getViewModel().lm.addElement(iteratorForFiles.next());
            }
        }

    }

}