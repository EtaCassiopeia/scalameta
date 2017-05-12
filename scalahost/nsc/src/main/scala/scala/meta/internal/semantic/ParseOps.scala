package scala.meta.internal
package semantic

import scala.{meta => m}
import scala.reflect.io.{PlainFile => GPlainFile}

trait ParseOps { self: DatabaseOps =>

  implicit class XtensionCompilationUnitSource(unit: g.CompilationUnit) {
    def toSource: m.Source = {
      unit.cache.getOrElse("source", dialect(unit.source.toInput).parse[m.Source].get)
    }
  }
}
