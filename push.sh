#!/bin/bash
git add .
git commit -m "$1"
git push origin

remote=`git remote -v`
echo "推送成功" $remote

