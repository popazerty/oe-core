require linux-firmware.inc

SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware/rtlwifi
        install -m 0644 rtlwifi/rtl8712u.bin ${D}/${base_libdir}/firmware/rtlwifi/
}

