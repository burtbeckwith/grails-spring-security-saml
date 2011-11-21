/* Copyright 2006-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

includeTargets << new File("$springSecuritySamlPluginDir/scripts/_SamlCommon.groovy")
includeTargets << new File("$springSecuritySamlPluginDir/scripts/_SamlConfig.groovy")
includeTargets << grailsScript('_GrailsBootstrap')

target (samlQuickstart: 'Creates base configuration files to aid saml integration.') {

	ant.mkdir(dir:"${basedir}/grails-app/conf/security")
	ant.copy(todir:"${basedir}/grails-app/conf/security") {
		fileset(dir:"${springSecuritySamlPluginDir}/grails-app/conf/security") {
			include(name:"*.*")
		}
	}
	
	updateConfig baseConfig
	
	printMessage """
*******************************************************
* Created a keystore and example metadata file in     *
* grails-app/conf/security.                           *
*                                                     *
* grails-app/conf/Config.groovy has been updated with *
* base configuration parameters that you will want to *
* change.                                             *
*******************************************************
"""
}

setDefaultTarget 'samlQuickstart'