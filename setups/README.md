setups
======

This folder contains various scripts and utilities to setup [glu](http://pongasoft.github.io/glu/docs/latest/html/index.html) on various environments and platforms.


Upstart script for the agent server
-----------------------------------

You can put `glu-agent.conf` under `/etc/init` on an OS that uses [upstart](http://upstart.ubuntu.com).

You will need to cusomize a few lines to match your own setup:
* `APP_USER`: the user under which you want to run the agent.
* `APP_DIR`: the full path where Glu is deployed.
* `APP_SCRIPT`: the full path to the `agent-server.sh` script.
* `setuid`: same as `APP_USER`.
* `setgid`: the group under which to run the agent.
* `chdir`: the directory when the scripts will run from, should be the same as `APP_DIR`.

_Tested on [Ubuntu 12.04 LTS](http://releases.ubuntu.com/precise/)._
