#!/bin/bash

imageType=$1

if [[ -z "${imageType}" ]]; then
    echo "building all images"
    pushd /vagrant
        echo "creating the build image"
        gradle :app:createBuildImage # create build image

        echo
        gradle :app:createAppImage # create the build image
    popd

elif [[ "${imageType}" == "build" ]]; then

    echo "building the build iamge"
    pushd /vagrant
        gradle :app:createBuildImage
    popd

elif [[ "${imageType}" == "app" ]]; then

    echo "building the app iamge"
    pushd /vagrant
        gradle :app:createAppImage
    popd

else

    echo "building all images"
    pushd /vagrant
        echo "creating all image"
        gradle :app:createBuildImage # create build image

        echo
        gradle :app:createAppImage # create the build image
    popd

fi

exit 0