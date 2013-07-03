/*
 * Copyright (c) 2011 Yan Pujante
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

spec = [
  name: 'glu-scripts-contrib',
  group: 'org.pongasoft',
  version: '1.0.0',

  versions: [
    jdk: '1.7',
    glu: '5.0.0',
    groovy: '2.0.7',
    utilsMisc: '2.0.0',
  ],

  // information about the build framework itself
  build: [
    type: "gradle",
    commands: [
      "snapshot": "./gradlew clean test publish",
      "release": "./gradlew -Prelease=true clean publish"
    ]
  ]
]

spec.scmUrl = "git@github.com:pongasoft/glu-contribs.git"

/**
 * External dependencies
 */
spec.external = [
  gluAgentAPI: "org.pongasoft:org.linkedin.glu.agent-api:${spec.versions.glu}",
  gluScriptsTestFwk: "org.pongasoft:org.linkedin.glu.scripts-test-fwk:${spec.versions.glu}",
  groovy: "org.codehaus.groovy:groovy-all:${spec.versions.groovy}",
  junit: 'junit:junit:4.10',
  utilsMiscCore: "org.pongasoft:org.linkedin.util-core:${spec.versions.utilsMisc}",
  utilsMiscGroovy: "org.pongasoft:org.linkedin.util-groovy:${spec.versions.utilsMisc}",
]
