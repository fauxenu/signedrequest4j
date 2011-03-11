/*
 * Copyright 2011 Kazuhiro Sera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.github.seratch.signedrequest4scala

import java.net.HttpURLConnection

trait SignedRequest {

  /**
   * Returns Signed {@link HttpURLConnection} instance.
   *
   * @param url    Request URL
   * @param method HTTP Method
   * @return Signed {@link HttpURLConnection} instance
   * @throws IOException
   */
  def getHttpURLConnection(url: String, method: HttpMethod): HttpURLConnection


  /**
   * Set RSA Private Key Value
   *
   * @param rsaPrivateKeyValue RSA Private Key PEM Value
   * @return Self
   */
  def setRsaPrivateKeyValue(rsaPrivateKeyValue: String): SignedRequest

  /**
   * Returns OAuth Signature Base String.
   *
   * @param url            Request URL
   * @param method         HTTP Method
   * @param oAuthNonce     OAuth Nonce Value
   * @param oAuthTimestamp OAuth Timestamp Value
   * @return OAuth Signature Base String
   */
  def getSignatureBaseString(url: String, method: HttpMethod, oAuthNonce: String, oAuthTimestamp: Long): String

  /**
   * Returns OAuth Signature.
   *
   * @param url            Request URL
   * @param method         HTTP Method
   * @param oAuthNonce     OAuth Nonce Value
   * @param oAuthTimestamp OAuth Timestamp Value
   * @return OAuth Signature
   */
  def getSignature(url: String, method: HttpMethod, oAuthNonce: String, oAuthTimestamp: Long): String

  /**
   * Do HTTP request and returns Http response
   *
   * @param url               Request URL
   * @param method            HTTP Method
   * @param requestParameters Request parameters(OPTIONAL)
   * @param charset           Charset
   * @return HTTP Response
   * @throws IOException
   */
  def doRequest(url: String, method: HttpMethod, requestParameters: Map[String, Any], charset: String): HttpResponse

  /**
   * Do GET / HTTP/1.1 request and returns Http response
   *
   * @param url     Request URL
   * @param charset Charset
   * @return HTTP Response
   * @throws IOException
   */
  def doGet(url: String, charset: String): HttpResponse

  /**
   * Do POST / HTTP/1.1 request and returns Http response
   *
   * @param url               Request URL
   * @param requestParameters Request parameters
   * @param charset           Charset
   * @return HTTP Response
   * @throws IOException
   */
  def doPost(url: String, requestParameters: Map[String, Any], charset: String): HttpResponse

  /**
   * Do PUT / HTTP/1.1 request and returns Http response
   *
   * @param url Request URL
   * @return HTTP Response
   * @throws IOException
   */
  def doPut(url: String): HttpResponse

  /**
   * Do DELETE / HTTP/1.1 request and returns Http response
   *
   * @param url Request URL
   * @return HTTP Response
   * @throws IOException
   */
  def doDelete(url: String): HttpResponse

  /**
   * Do HEAD / HTTP/1.1 request and returns Http response
   *
   * @param url Request URL
   * @return HTTP Response
   * @throws IOException
   */
  def doHead(url: String): HttpResponse

  /**
   * Do OPTIONS / HTTP/1.1 request and returns Http response
   *
   * @param url Request URL
   * @return HTTP Response
   * @throws IOException
   */
  def doOptions(url: String): HttpResponse

  /**
   * Do TRACE / HTTP/1.1 request and returns Http response
   *
   * @param url Request URL
   * @return HTTP Response
   * @throws IOException
   */
  def doTrace(url: String): HttpResponse

}