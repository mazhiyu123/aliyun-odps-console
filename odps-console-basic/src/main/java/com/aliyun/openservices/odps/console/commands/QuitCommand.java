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

import com.aliyun.odps.OdpsException;
import com.aliyun.openservices.odps.console.ExecutionContext;
import com.aliyun.openservices.odps.console.ODPSConsoleException;

public class QuitCommand extends AbstractCommand {

  public static final String[] HELP_TAGS = new String[]{"quit", "q"};

  public static void printUsage(PrintStream stream) {
    stream.println("Usage: q|quit");
  }

  public void run() throws OdpsException, ODPSConsoleException {

    InteractiveCommand.quit = true;
  }

  public QuitCommand(String commandText, ExecutionContext context) {
    super(commandText, context);
  }

  public static QuitCommand parse(String commandString, ExecutionContext sessionContext) {
    if (commandString.toUpperCase().matches("\\s*Q\\s*")
        || commandString.toUpperCase().matches("\\s*QUIT\\s*")) {
      return new QuitCommand(commandString, sessionContext);
    }
    return null;
  }
}
