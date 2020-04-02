#!Groovy

package org.devops

//saltstack
def SaltDeploy(hosts, func){
    sh "salt \"${hosts}\" ${func}" 
}


//ansible
def Ansible(hosts, func){
    sh "ansible -m ${func} ${hosts}"
}
