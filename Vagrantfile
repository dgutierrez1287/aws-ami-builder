# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

    config.vm.box = "centos/7"
    config.vm.hostname = "aws-ami-builder-dev"

    config.vm.network "private_network", ip: "192.168.33.20"

    config.vm.synced_folder ".", "/vagrant", type: "virtualbox", create: true,
                            :owner => 'vagrant',
                            :mount_options => ['dmode=777', 'fmode=777']

    config.vm.provision "bootstrap", type: "shell" do |s|
      s.path = "vagrant_scripts/provision/bootstrap.sh"
    end

    config.vm.provision "ansible", type: "ansible_local" do |a|
      a.install = false
      a.provisioning_path = "/vagrant/vagrant_scripts/provision/ansible"
      a.playbook = "playbook.yml"
    end

    config.vm.provider "virtualbox" do |v|
        v.name = "aws-ami-builder-dev"

        v.gui = false
        v.memory = "2048"

        v.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
        v.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end

end