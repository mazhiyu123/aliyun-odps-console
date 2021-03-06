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

package com.aliyun.openservices.odps.console.constants;

import com.aliyun.openservices.odps.console.utils.ODPSConsoleUtils;

/**
 * 保存一些console的提示信息
 *
 * @author shuman.gansm
 **/
public class ODPSConsoleConstants {

  // message
  public final static String BAD_COMMAND = "Bad Command, Type \"help;\"(--help) or \"h;\"(-h) for help. ";
  public final static String COMMAND_END_WITH = "Command must be end with \";\"";
  public final static String INVALID_PARAMETER_E = "Invalid parameter -e";
  public final static String LOAD_CONFIG_ERROR = "Load odps config error";
  public final static String LOAD_VERSION_ERROR = "Load odps version-file error";
  public final static String PROJECT_NOT_BE_SET = "Project not be set! ";
  public final static String EXECUTIONCONTEXT_NOT_BE_SET = "ExecutionContext not be set! ";
  public final static String TABLE_TOO_MANY_COLUMNS = "Too many columns! ";
  public final static String PARTITION_SPC_ERROR = "Partition Spc error! eg : ds='20130406' ";
  public final static String COLUMNS_ERROR = "Columns error! ";
  public final static String COMING_SOON = "Coming soon...";
  public final static String LOCATION_IS_NULL = "Location is null from header";
  public final static String FILE_NOT_EXIST = "File not exist";
  public final static String FILE_UPLOAD_FAIL = "File upload fail";
  public final static String POLICY_SET_FAIL = "Policy Set fail";

  public final static String FILENAME_ENDWITH_PY = "File name must end with py";
  public final static String FILENAME_ENDWITH_JAR = "File name must end with jar";
  public final static String FILENAME_ENDWITH_MORE = "File name(alias name) must end with .jar/.zip/.tgz/.tar.gz/.tar";

  public final static String MUST_SET_ALIAS = "Must set alias";
  public final static String CANNOT_SET_ALIAS = "Can not set alias";

  public final static String FAILED_MESSAGE = "FAILED: ";

  // interactive command
  public final static String ODPS = "@ODPS";
  public final static String IDENTIFIER = ">";
  public final static String ALIYUN_ODPS_UTILITIES_VERSION = "Aliyun ODPS Command Line Tool\nVersion " + ODPSConsoleUtils.getMvnVersion() + "\n@Copyright 2015 Alibaba Cloud Computing Co., Ltd. All rights reserved.";
  public final static String ODPS_LOGIN = "ODPS login:";

  // odps_config.ini, properties key
  public static final String PROJECT_NAME = "project_name";
  public static final String ACCESS_ID = "access_id";
  public static final String ACCESS_KEY = "access_key";
  public static final String PROXY_HOST = "proxy_host";
  public static final String PROXY_PORT = "proxy_port";
  public static final String END_POINT = "end_point";
  public static final String DATA_SIZE_CONFIRM = "data_size_confirm";

  public static final String LOG_VIEW_HOST = "log_view_host";
  public static final String IS_DEBUG = "debug";
  public static final String ACCOUNT_PROVIDER = "account_provider";
  public static final String INSTANCE_PRIORITY = "instance_priority";

  // hook class
  public static final String POST_HOOK_CLASS = "post_hook_class";
  public static final String USER_COMMANDS = "user_commands";
  public static final String TUNNEL_ENDPOINT = "tunnel_endpoint";
  public static final String DATAHUB_ENDPOINT = "hub_endpoint";
  public static final String RUNNING_CLUSTER = "running_cluster";

  public static String HTTPS_CHECK = "https_check";

  public static String SQLCOMMANDS = "sqlcommands";

  public static String PRINTCMDS = "printcommand";
}
