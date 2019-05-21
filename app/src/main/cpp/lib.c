//
// Created by Hoyet on 11/04/2019.
//

#include <jni.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "hwloc/hwloc/misc.c"
#include "hwloc/hwloc/bitmap.c"
#include "hwloc/hwloc/distances.c"
#include "hwloc/hwloc/topology.c"
#include "hwloc/hwloc/traversal.c"
#include "hwloc/hwloc/bind.c"
#include "hwloc/hwloc/components.c"
#include "hwloc/hwloc/pci-common.c"
#include "hwloc/hwloc/topology-linux.c"
#include "hwloc/hwloc/shmem.c"
#include "hwloc/hwloc/topology-xml.c"
#include "hwloc/hwloc/base64.c"
#include "hwloc/hwloc/topology-hardwired.c"
#include "hwloc/hwloc/topology-noos.c"
#include "hwloc/hwloc/topology-synthetic.c"
#include "hwloc/utils/hwloc/common-ps.c"
#include "hwloc/utils/lstopo/lstopo.c"
#include "hwloc/utils/lstopo/lstopo-text.c"
#include "hwloc/utils/lstopo/lstopo-ascii.c"
#include "hwloc/utils/lstopo/lstopo-draw.c"
#include "hwloc/utils/lstopo/lstopo-fig.c"
#include "hwloc/utils/lstopo/lstopo-svg.c"
#include "hwloc/utils/lstopo/lstopo-xml.c"
#include "hwloc/utils/lstopo/lstopo-mobile.c"
#include "hwloc/utils/lstopo/lstopo-mobile-text.c"


JNIEXPORT void JNICALL Java_com_example_lstopo_MainActivity_draw(JNIEnv *env, jobject _this, jobject lstopo){
    char *argv[2];
    argv[0] = lstopo;
    argv[1] = env;
    main(1, argv);
}

JNIEXPORT void JNICALL Java_com_example_lstopo_MainActivity_text(JNIEnv *env, jobject _this, jobject lstopo){
    char *argv[2];
    argv[0] = lstopo;
    argv[1] = env;
    main(2, argv);
}



