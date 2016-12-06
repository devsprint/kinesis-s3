/*
 * Copyright (c) 2014-2015 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.snowplow.storage.kinesis.s3.serializers

// Java libs
import java.io.ByteArrayOutputStream

import com.snowplowanalytics.snowplow.storage.kinesis.s3.EmitterStringInput

// This project
import com.snowplowanalytics.snowplow.storage.kinesis.s3.EmitterInput

case class NamedStream(filename: String, stream: ByteArrayOutputStream)

case class SerializationResult(namedStreams: List[NamedStream], results: List[EmitterStringInput])

/**
 * Shared interface for all serializers
 */
trait ISerializer {
  def serialize(records: List[ EmitterStringInput ], baseFilename: String): SerializationResult
}
