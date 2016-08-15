#!/usr/bin/env python
#
# Copyright (c) 2015, Kuvacode Oy
# All rights reserved. No warranty, explicit or implicit, provided.
#

import zmq
import math
import ast
import json
import socket
import os
import time

def main():
    seq_num = 0
    context = zmq.Context()
    sub_address = "tcp://127.0.0.1:54543"
    sub_socket = context.socket(zmq.SUB)
    sub_socket.setsockopt(zmq.SUBSCRIBE, b"")
    sub_socket.connect(sub_address)
	
    HOST = "localhost"
    PORT = 50000
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect((HOST, PORT))
	
    while (True):
        raw = sub_socket.recv()
        msg = raw.decode("utf-8-sig")
        #sock.send(bytes('20160801\\C001\\016\\D800E.JPG'+'\n','UTF-8'))
        #data = sock.recv(1024)
        #print (data)
		#print (len(msg))
        #print (len(msg))
        if len(msg) > 680 and len(msg) < 800:
            msg2 = json.loads(msg)
        #print (msg2)
            if "PhotoComputedName" in msg2:
                #print (msg2["PhotoComputedName"])
                sock.send(bytes(msg2["PhotoComputedName"]+'\n', 'UTF-8'))
        #    print(json_msg)
        #else:
        #    print ("there is no")

if __name__ == '__main__':
    main()
