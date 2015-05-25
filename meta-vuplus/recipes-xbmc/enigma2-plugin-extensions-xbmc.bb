SECTION = "base"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PKG_DATE="20141219.0_beta"

PV="1.1"
PR="${PKG_DATE}_r2"

DEPENDS += "enigma2 virtual/xbmc"
RDEPENDS_${PN} += "virtual/xbmc"

SRC_URI = "http://archive.vuplus.com/download/build_support/e2xbmc-plugin_${PKG_DATE}.tar.gz \
		file://ps.patch \
"

S = "${WORKDIR}/plugin"

PLUGIN_DIR="${D}${libdir}/enigma2/python/Plugins/Extensions/XBMC"

do_install() {
	install -d ${PLUGIN_DIR}
	install -m 0755 ${S}/*.py ${PLUGIN_DIR}
	install -m 0755 ${S}/button.png ${PLUGIN_DIR}
}

do_package_qa() {
}

FILES_${PN}="/"

SRC_URI[md5sum] = "31542f3ad42725d2a7ac498be4870e31"
SRC_URI[sha256sum] = "f662de7daab96fa690686cbefab597f0cf5e42a7abfc6e414faa1f1c4aff1cdc"

