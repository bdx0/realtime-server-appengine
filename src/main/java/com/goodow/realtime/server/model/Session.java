/*
 * Copyright 2012 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime.server.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.io.Serializable;

/**
 * A client ID. See walkaround.proto for more information.
 */
public final class Session implements Serializable {
  private static final long serialVersionUID = 897917221735180820L;

  public final String userId;
  public final String sessionId;

  public Session(String userId, String sessionId) {
    Preconditions.checkNotNull(userId, "Null user id");
    Preconditions.checkNotNull(sessionId, "Null session id");
    this.userId = userId;
    this.sessionId = sessionId;
  }

  @Override
  public final boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Session)) {
      return false;
    }
    Session other = (Session) o;
    return Objects.equal(userId, other.userId) && Objects.equal(sessionId, other.sessionId);
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(sessionId);
  }

  @Override
  public String toString() {
    return "Session(" + userId + "," + sessionId + ")";
  }
}