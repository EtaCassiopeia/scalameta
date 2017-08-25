package lang.meta
package semanticdb

final case class Denotation(flags: Long, name: String, signature: String, resolvedNames: List[ResolvedName]) extends HasFlags {
  def syntax: String = {
    val s_info = if (signature != "") ": " + signature else ""
    val s_names = ResolvedName.syntax(resolvedNames)
    s"$flagSyntax $name" + s_info + s_names
  }
  def structure = s"""Denotation($flagStructure, "$name", "$signature")"""
  override def toString = syntax
}
