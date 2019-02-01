/**
 * lame decoder and encoder
 *
 * @author Reinhard（李剑波）
 * @date 2019/1/31
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "lame.h"
#include "console.h"
#include "main.h"

static int c_main(int argc, char *argv[]) {
    lame_t gf;
    int ret;

    frontend_open_console();
    gf = lame_init(); /* initialize libmp3lame */
    if (NULL == gf) {
        error_printf("fatal error during initialization\n");
        ret = 1;
    } else {
        ret = lame_main(gf, argc, argv);
        lame_close(gf);
    }
    frontend_close_console();
    return ret;
}

int lame_codec_main(int argc, char *argv[]) {
    return c_main(argc, argv);
}
