#!/usr/bin/env bash
n=1
while [ $n -le 50 ]
do
    echo `curl -s http://localhost:9002/feign/get-user`
    let n++
done
