package com.dxysun.idea.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.InputValidator;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.NonEmptyInputValidator;
import com.intellij.psi.PsiFile;

import javax.swing.*;

public class CommitMsgAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        //获取当前在操作的工程上下文
        Project project = e.getData(PlatformDataKeys.PROJECT);

        //获取当前操作的类文件
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //获取当前类文件的路径
        String classPath = psiFile.getVirtualFile().getPath();
        String title = "Hello World!";


        //显示对话框
//        Messages.showMessageDialog(project, classPath, title, Messages.getInformationIcon());
        Icon icon = new ImageIcon();
//        Messages.showInputDialog("commitInut", "commitMsg", icon);
        InputValidator inputValidator = new NonEmptyInputValidator();
        String[] strings = new String[]{"test1","test2"};
        Messages.showEditableChooseDialog("commitInut", "commitMsg", icon, strings, "test",inputValidator);


    }
}
