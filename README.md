# TLSFuzzer

## Goal

## Roadmap

# SSL Server
## OpenSSL
`openssl req -x509 -newkey rsa:2048 -keyout key.pem -out cert.pem -days 365 -nodes`  
`openssl s_server -key key.pem -cert cert.pem -accept 44330 -www -debug`  
## ncat
`ncat -vvvv --listen --ssl`

# SSL Client
## OpenSSL
`openssl s_client -connect localhost:44330`  
 
# SSL Knowledge base

[RFC8446](https://datatracker.ietf.org/doc/html/rfc8446#appendix-A.1)  
[TLS1.2 bytebybyte description](https://tls12.xargs.org)  
[TLS1.3 bytebybyte description](https://tls13.xargs.org)  
[ncat with ssl](https://nmap.org/ncat/guide/ncat-ssl.html)  