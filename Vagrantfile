# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

    config.vm.box = "centos/7"
    config.vm.hostname = "aws-ami-builder-dev"

    config.vm.network "forwarded_port", guest: 3306, host: 9106, auto_correct: true

    config.vm.provision "shell", path: "vagrant_scripts/provision/turn_off_firewall.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/install_mysql.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/install_docker.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/install_java8.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/install_groovy.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/install_gradle.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/dev_env_setup.sh"

    config.vm.synced_folder ".", "/vagrant", create: true,
    :owner => 'vagrant',
    :mount_options => ['dmode=777', 'fmode=777']

    config.vm.provider "virtualbox" do |v|
        v.name = "aws-ami-builder-dev"

        v.gui = false
        v.memory = "2048"

        v.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
        v.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end

end