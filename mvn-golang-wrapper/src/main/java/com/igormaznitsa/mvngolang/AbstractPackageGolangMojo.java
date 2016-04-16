/*
 * Copyright 2016 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.mvngolang;

import javax.annotation.Nonnull;

import javax.annotation.Nullable;
import org.apache.maven.plugins.annotations.Parameter;

import com.igormaznitsa.meta.annotation.MustNotContainNull;
import com.igormaznitsa.meta.common.utils.ArrayUtils;
import com.igormaznitsa.meta.common.utils.GetUtils;

public abstract class AbstractPackageGolangMojo extends AbstractGolangMojo {
  /**
   * List of packages.
   */
  @Parameter(name = "packages")
  private String[] packages;

  @Nullable
  @MustNotContainNull
  public String [] getPackages(){
    return this.packages == null ? null : this.packages.clone();
  }
  
  @Override
  @Nonnull
  @MustNotContainNull
  public String[] getTailArguments() {
    return GetUtils.ensureNonNull(getPackages(), ArrayUtils.EMPTY_STRING_ARRAY);
  }

  @Override
  @Nonnull
  @MustNotContainNull
  public String[] getCommandFlags() {
    return ArrayUtils.EMPTY_STRING_ARRAY;
  }
}
