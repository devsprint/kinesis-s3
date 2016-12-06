package com.snowplowanalytics.snowplow.storage.kinesis.s3

import com.amazonaws.services.kinesis.connectors.interfaces.ITransformer
import com.amazonaws.services.kinesis.model.Record
import org.apache.commons.logging.LogFactory


// Scalaz
import scalaz._
import Scalaz._


/**
  * Created by gciuloaica on 06/12/2016.
  */
class StringEventTransformer extends ITransformer[ ValidatedStringRecord, EmitterStringInput ] {
  val log = LogFactory.getLog(getClass)

  override def toClass(record: Record): ValidatedStringRecord = {
    log.info("Converting one record to EmitterInput before adding it to the buffer")
    (new String(record.getData.array)).success
  }

  override def fromClass(record: ValidatedStringRecord) = record

}
