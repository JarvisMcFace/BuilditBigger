/*
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
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-02-15 17:18:02 UTC)
 * on 2017-03-30 at 04:48:34 UTC 
 * Modify at your own risk.
 */

package com.udacity.gradle.builditbigger.backend.myApi.model;

/**
 * Model definition for Joke.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Joke extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String answer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String question;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAnswer() {
    return answer;
  }

  /**
   * @param answer answer or {@code null} for none
   */
  public Joke setAnswer(java.lang.String answer) {
    this.answer = answer;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getQuestion() {
    return question;
  }

  /**
   * @param question question or {@code null} for none
   */
  public Joke setQuestion(java.lang.String question) {
    this.question = question;
    return this;
  }

  @Override
  public Joke set(String fieldName, Object value) {
    return (Joke) super.set(fieldName, value);
  }

  @Override
  public Joke clone() {
    return (Joke) super.clone();
  }

}