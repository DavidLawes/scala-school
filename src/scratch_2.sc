import common.SNSNotification
import conf.switches.Switches.FrontPressJobSwitch

import scala.concurrent.Future

def process(message: common.Message[SNSNotification]): Future[Unit] = {
  val path: String = message.get.Message

  //  if (FrontPressJobSwitch.isSwitchedOn) {
  //    log.info(s"Cron pressing path $path")

  try {
    //        val pressFuture = liveFapiFrontPress
    //          .pressByPathId(path, message.id.get)
    //          .map(Function.const(()))
    //
    //        pressFuture.foreach { _ =>
    //          FrontPressCronSuccess.increment()
    //        }
    //
    //        pressFuture
    throw new Error("test error")
  } catch {
    case e: Exception => {
      println(s"Failure processing SNS notification: ${message}")
      throw e
    }
    //    }
  }
}

process()