/*
 * Copyright 2001-2009 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples

/*
ScalaTest also supports the behavior-driven development style, in which you
combine tests with text that specifies the behavior being tested. Here's
an example whose text output when run looks like:

A Map
- should only contain keys and values that were added to it
- should report its size as the number of key/value pairs it contains
*/
import org.scalatest.Spec
import org.scalatest.matchers.MustMatchers

class MapSpec extends Spec with MustMatchers {

  describe("A Map") {

    it("should only contain keys and values that were added to it") {
      Map("ho" -> 12) must (not contain key ("hi") and not contain value (13))
      Map("hi" -> 13) must (contain key ("hi") and contain value (13))
    }

    it("should report its size as the number of key/value pairs it contains") {
      Map() must have size (0)
      Map("ho" -> 12) must have size (1)
      Map("hi" -> 13, "ho" -> 12) must have size (2)
    }
  }
}

