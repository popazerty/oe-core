SUMMARY = "Download videos from YouTube (and more sites)"
DESCRIPTION = "youtube-dl is a small command-line program to download videos \
from YouTube.com and a few more sites. It requires the Python interpreter \
(2.6, 2.7, or 3.2+), and it is not platform specific"
HOMEPAGE = "http://rg3.github.io/youtube-dl/"
SECTION = "devel/python"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"
DEPENDS = "libxml2 python-html"
SRCREV = "3220c50f9af3a1df239656025aebfe00fec00e45"
PV = "2015.04.17"

SRC_URI = "git://github.com/rg3/youtube-dl.git;branch=master"

S = "${WORKDIR}/git"

inherit setuptools

RDEPENDS_${PN} = " \
	python-email \
	python-gdata \
	python-subprocess \
	python-unixadmin \
	"

PACKAGES =+ " ${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/${PYTHON_DIR}/site-packages/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/*/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/*/*/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/*/*/*/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/youtube_dl-*-py2.7.egg-info/* \
	${datadir}/etc/* \
	"

