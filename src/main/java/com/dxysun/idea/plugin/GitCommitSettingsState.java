// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.dxysun.idea.plugin;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "com.dxysun.idea.plugin.GitCommitSettingsState",
        storages = {@Storage("GitCommitMsg.xml")}
)
public class GitCommitSettingsState implements PersistentStateComponent<GitCommitSettingsState> {

  public String userId = "dxy";
  public boolean ideaStatus = false;

  public static GitCommitSettingsState getInstance() {
    return ServiceManager.getService(GitCommitSettingsState.class);
  }

  @Nullable
  @Override
  public GitCommitSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull GitCommitSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}
