#!Groovy

package org.devops

//saltstack
def SaltDeploy(host, func){
    sh "salt \"${host}\" ${func}" 
}
