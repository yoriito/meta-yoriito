SUMMARY = "Yoriito VSS JSON file based on COVESA v5.0 release"
DESCRIPTION = "Installs vss.json to /usr/vss from the v5.0 release of the COVESA Vehicle Signal Specification"
AUTHOR = "Yoriito"
HOMEPAGE = "https://github.com/yoriito/yoriito-vss"
BUGTRACKER = "None"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"

SRC_URI = "git://github.com/yoriito/yoriito-vss.git;protocol=https;branch=main"
SRCREV = "5188e946bc68fefd75882ceb5db115c75e67dd1c"

S = "${WORKDIR}/git"

do_install() {
    # NOTES: This recipe installs the already built vss.json
    install -d ${D}${sysconfdir}/yoriito/viss
    install -m 0644 ${S}/artifact/yoriito_vss.json ${D}${sysconfdir}/yoriito/viss/vss.json
    install -d ${D}${datadir}/yoriito
    install -m 0644 ${S}/artifact/yoriito_vss.csv ${D}${datadir}/yoriito
}

FILES:${PN} += "${sysconfdir} ${datadir}"
