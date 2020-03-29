#!groovy
@Library('jenkinslib') _

def tools = new org.devops.tools()

String workspace = "/opt/jenkins/workspace"

pipeline{
	environment {
		CC = "ZHUXIANG"
	}

	agent { 
		node { 
			label "master"  //指定运行节点的标签或者名称
			customWorkspace "${workspace}"  //指定运行工作目录（可选）
		}
	}

	options {
		timestamps() //日志会有时间
		skipDefaultCheckout() //删除隐式checkout scm语句
		disableConcurrentBuilds() //禁止并行
		timeout(time: 1,unit: 'HOURS') //流水线超时设置1h
	}

	stages {
		//下载代码
		stage("GetCode"){ //阶段名称
			steps{ //步骤
				timeout(time:5, unit:"MINUTES"){ //步骤超时时间
					script{ //填写运行代码
						println('获取代码')
						tools.PrintMes("获取代码",'green')
						println(CC)
					}
				}
			}
		}

		//构建
		stage("Build"){
			steps{
				timeout(time:20, unit:"MINUTES"){
					script{
						println('应用打包')
						tools.PrintMes("应用打包",'green')
					}
				}
			}
		}

		//代码扫描
		stage("CodeScan"){
			steps{
				timeout(time:30, unit:"MINUTES"){
					script{
						print("代码扫描")
						tools.PrintMes("this is my lib!",'green')
					}
				}
			}
		}
	}

	//构建后操作
	post {
		always {
			script{
				println("always")
			}
		}

		success {
			script{
				currentBuild.description = "\n 构建成功！"
			}
		}

		failure {
			script{
				currentBuild.description = "\n 构建失败！"
			}
		}

		aborted {
			script{
				currentBuild.description = "\n 构建取消！"
			}
		}
	}
}
