/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.aliyun.openservices.odps.console.commands;

import java.io.PrintStream;

import org.jsoup.nodes.Document;

import com.aliyun.odps.Odps;
import com.aliyun.odps.OdpsException;
import com.aliyun.odps.utils.StringUtils;
import com.aliyun.openservices.odps.console.ExecutionContext;
import com.aliyun.openservices.odps.console.ODPSConsoleException;
import com.aliyun.openservices.odps.console.constants.ODPSConsoleConstants;
import com.aliyun.openservices.odps.console.output.DefaultOutputWriter;
import com.aliyun.openservices.odps.console.utils.ODPSConsoleUtils;
import com.aliyun.openservices.odps.console.utils.OdpsConnectionFactory;

/**
 * 所有command，从此抽象类来实现
 * 
 * @author shuman.gansm
 * */

/*
 * 2种类型的Command
 * 交互式 parse(String, context) 执行-e 和 -f
 * 非交互式 parse(List<String> Option, context)
 */
public abstract class AbstractCommand {

  // 每个命令会保存对应的上下文件
  private ExecutionContext context;
  // 每个命令都有对应的命令行
  // 命令解析出来后，需要set一下命令行
  private String commandText;

  // default
  int commandStep = -1;

  public int getCommandStep() {
    return commandStep;
  }

  public void setCommandStep(int commandStep) {
    this.commandStep = commandStep;
  }

  public AbstractCommand(String commandText, ExecutionContext context) {
    super();
    this.context = context;
    this.commandText = commandText;
  }

  public abstract void run() throws OdpsException, ODPSConsoleException;

  public ExecutionContext getContext() {
    assert (context != null);

    return context;
  }

  public String getCommandText() {
    return commandText;
  }

  public DefaultOutputWriter getWriter() {

    ExecutionContext context = this.getContext();
    return context.getOutputWriter();
  }

  /**
   * 创建当前session对应的project
   * */
  public String getCurrentProject() throws ODPSConsoleException {

    ExecutionContext context = this.getContext();
    if (context == null) {
      throw new ODPSConsoleException(ODPSConsoleConstants.EXECUTIONCONTEXT_NOT_BE_SET);
    }

    String project = context.getProjectName();
    if (project == null || project.trim().equals("")) {
      throw new ODPSConsoleException(ODPSConsoleConstants.PROJECT_NOT_BE_SET);
    }

    return project;

  }
  
  /**
   * 创建当前session对应的Odps
   * @throws ODPSConsoleException 
   * */
  public Odps getCurrentOdps() throws ODPSConsoleException {

    return OdpsConnectionFactory.createOdps(getContext());
  }

  public void setContext(ExecutionContext context) {
    this.context = context;
  }

  public static final String[] HELP_TAGS = new String[]{};

  /**
   * Print the usage of command
   * Each
   */
  public static void printUsage(PrintStream stream) {
    stream.println("This command have no help info");
  }

  public String runHtml(Document dom) throws OdpsException, ODPSConsoleException {

    String result = "";
    try {
      result = ODPSConsoleUtils.runCommand(this);
      dom.body().appendElement("div").appendElement("pre").html(result);
    } catch (OdpsException e) {
      result = StringUtils.stringifyException(e);
      dom.body().appendElement("div").appendElement("pre").html(result).attr("style", "color:red");
    } catch (ODPSConsoleException e) {
      result = StringUtils.stringifyException(e);
      dom.body().appendElement("div").appendElement("pre").html(result).attr("style", "color:red");
    }
    System.out.println(result);
    return dom.toString();
  }
}
