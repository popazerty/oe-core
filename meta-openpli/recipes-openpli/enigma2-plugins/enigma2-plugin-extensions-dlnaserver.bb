DESCRIPTION = "VU+ DLNA Server plugin"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9e255efa454e0155c1fd758df7dcaf3"
BRANCH = "vuplus_experimental"
S = "${WORKDIR}/git"
SRC_URI = "git://code.vuplus.com/git/dvbapp.git;protocol=http;branch=${BRANCH};tag=${SRCREV} \
	file://01-minidlna.patch;striplevel=1;apply=yes \
	file://02-readymedia.patch;striplevel=1;apply=yes \
"

inherit gitpkgv
SRCREV = "bbc323853f72cb7d5531cb87af04ffb4cd6e99c9"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

RDEPENDS_${PN} = "readymedia"
FILES_${PN} = "/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer/*"
PACKAGES = "${PN}"

do_install() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer
	install -m 0644 ${S}/lib/python/Plugins/Extensions/DLNAServer/*.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer
	python -O -m compileall ${D}/usr/lib/enigma2/python/Plugins/
}
