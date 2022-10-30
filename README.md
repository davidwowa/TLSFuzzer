# TLSFuzzer

# Roadmap

TODO

[TLS1.2 bytebybyte description](https://tls12.xargs.org)  
[TLS1.3 bytebybyte description](https://tls13.xargs.org)  

# OpenSSL Server

`openssl req -x509 -newkey rsa:2048 -keyout key.pem -out cert.pem -days 365 -nodes`  
`openssl s_server -key key.pem -cert cert.pem -accept 44330 -www -debug`  
`ncat -vvvv --listen --ssl`  