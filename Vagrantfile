# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

    config.vm.box = "centos/7"
    config.vm.hostname = "aws-ami-builder-dev"

    config.vm.network "forwarded_port", guest: 3000, host: 3000, auto_correct: true
    config.vm.network "forwarded_port", guest: 3306, host: 9106, auto_correct: true

    config.vm.provision "shell", path: "vagrant_scripts/provision/turn_off_firewall.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/install_mysql.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/python_setup.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/js_setup.sh"
    config.vm.provision "shell", path: "vagrant_scripts/provision/dev_env_setup.sh"

    config.vm.synced_folder "src/", "/home/vagrant/aws-ami-builder/", create: true
    config.vm.synced_folder "vagrant_scripts/utility/", "/home/vagrant/scripts/", create: true,
    :owner => 'vagrant',
    :mount_options => ['dmode=775', 'fmode=775']

    config.vm.provider "virtualbox" do |v|
        v.name = "aws-ami-builder-dev"
    end

end
