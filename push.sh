#!/bin/bash


function push(){
    git add .
    git commit -m "$1" &>/dev/null
    git push origin &>/dev/null

    remote=`git remote -v` 
    echo "推送成功" $remote
}

if [ $# -eq 0 ];then
    echo "请填写commit::请输入 bash ./push.sh fix：bug"
else push $1
fi

