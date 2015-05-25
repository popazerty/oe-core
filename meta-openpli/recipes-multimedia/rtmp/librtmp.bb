DESCRIPTION = "librtmp Real-Time Messaging Protocol API"
LICENSE = "LGPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=e344c8fa836c3a41c4cbd79d7bd3a379"

DEPENDS = "openssl zlib"

inherit gitpkgv

SRCREV = "a1900c3e152085406ecb87c1962c55ec9c6e4016"

PKGV = "2.4+git${GITPKGV}"
PV = "2.4+git${SRCPV}"
PR = "r2"

SRC_URI = "git://git.ffmpeg.org/rtmpdump;protocol=git \
	file://0001-librtmp-set-timeout-for-send-operations-too.patch;striplevel=2 \
"

S = "${WORKDIR}/git/librtmp"

do_compile() {
	oe_runmake CROSS_COMPILE=${TARGET_PREFIX} CFLAGS="${CFLAGS} -fPIC" LDFLAGS="${LDFLAGS}"
}

do_install() {
	install -d ${D}${libdir}
	oe_runmake DESTDIR=${D} install
}
