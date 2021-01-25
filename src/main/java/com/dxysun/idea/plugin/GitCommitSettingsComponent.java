// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.dxysun.idea.plugin;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBCheckBoxMenuItem;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class GitCommitSettingsComponent {

  private final JPanel myMainPanel;
  private final JBTextField myUserNameText = new JBTextField();
  private final JBCheckBox commitPluginStatus = new JBCheckBox("disable", true);
  private final JBRadioButton jbRadioButton = new JBRadioButton();

  private final JButton addProfileButton = new JButton("保存配置");

  public GitCommitSettingsComponent() {
//    commitPluginStatus.setSelected(false);

    myMainPanel = FormBuilder.createFormBuilder()
            .addComponent(jbRadioButton, 1)
            .addLabeledComponent(new JBLabel("输入配置名称: "), myUserNameText, 1, false)
            .addComponentToRightColumn(addProfileButton)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
  }

  public JPanel getPanel() {
    return myMainPanel;
  }

  public JComponent getPreferredFocusedComponent() {
    return myUserNameText;
  }

  @NotNull
  public String getUserNameText() {
    return myUserNameText.getText();
  }

  public void setUserNameText(@NotNull String newText) {
    myUserNameText.setText(newText);
  }

  public boolean getIdeaUserStatus() {
    return commitPluginStatus.isSelected();
  }

  public void setIdeaUserStatus(boolean newStatus) {
    commitPluginStatus.setSelected(newStatus);
  }

}
