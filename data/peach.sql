/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : peach

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 14/03/2022 23:18:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `dynamic_id` int NOT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_comment_did`(`dynamic_id`) USING BTREE,
  CONSTRAINT `FK_comment_did` FOREIGN KEY (`dynamic_id`) REFERENCES `dynamic_` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for dynamic_
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_`;
CREATE TABLE `dynamic_`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `dynamic_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `love_number` int NULL DEFAULT 0,
  `comment_number` int NULL DEFAULT 0,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_dynamic_uid`(`uid`) USING BTREE,
  CONSTRAINT `FK_dynamic_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic_
-- ----------------------------
INSERT INTO `dynamic_` VALUES (1, 2, '全力以赴推倒对面，是战争的基本礼仪', 'img1', 67, 67, '2021-12-07 22:30:29', NULL);
INSERT INTO `dynamic_` VALUES (2, 3, '好好反省', 'img3', 44, 44, '0000-00-00 00:00:00', NULL);
INSERT INTO `dynamic_` VALUES (3, 1, '有些罪不会消失，有些事非做不可。', 'img2', 0, 0, '0000-00-00 00:00:00', NULL);
INSERT INTO `dynamic_` VALUES (4, 1, '邂逅，让我回忆起重要的事。', 'img4', 0, 0, '0000-00-00 00:00:00', NULL);

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus`  (
  `uid` int NOT NULL,
  `fid` int NOT NULL,
  PRIMARY KEY (`uid`, `fid`) USING BTREE,
  INDEX `FK_focus_fid`(`fid`) USING BTREE,
  CONSTRAINT `FK_focus_fid` FOREIGN KEY (`fid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_focus_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of focus
-- ----------------------------
INSERT INTO `focus` VALUES (1, 2);
INSERT INTO `focus` VALUES (3, 2);
INSERT INTO `focus` VALUES (1, 3);

-- ----------------------------
-- Table structure for poetry
-- ----------------------------
DROP TABLE IF EXISTS `poetry`;
CREATE TABLE `poetry`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `poetry_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `poetry_transform` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `poetry_notes` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `poetry_appreciation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `creative_background` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `author_introduction` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `English_translation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `French_translation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `Russian_translation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `Japanese_translation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `Korean_translation` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of poetry
-- ----------------------------
INSERT INTO `poetry` VALUES (1, '茅屋为秋风所破歌\r\n杜甫 〔唐代〕\r\n八月秋高风怒号，卷我屋上三重茅。茅飞渡江洒江郊，高者挂罥长林梢，下者飘转沉塘坳。\r\n南村群童欺我老无力，忍能对面为盗贼。公然抱茅入竹去，唇焦口燥呼不得，归来倚杖自叹息。\r\n俄顷风定云墨色，秋天漠漠向昏黑。布衾多年冷似铁，娇儿恶卧踏里裂。床头屋漏无干处，雨脚如麻未断绝。自经丧乱少睡眠，长夜沾湿何由彻！\r\n安得广厦千万间，大庇天下寒士俱欢颜！风雨不动安如山。呜呼！何时眼前突兀见此屋，吾庐独破受冻死亦足！(亦足 一作：意足)', '八月秋深狂风大声吼叫，狂风卷走了我屋顶上好几层茅草。茅草乱飞渡过浣花溪散落在对岸江边，飞得高的茅草缠绕在高高的树梢上，飞得低的飘飘洒洒沉落到池塘和洼地里。\r\n南村的一群儿童欺负我年老没力气，竟狠心这样当面做“贼”抢东西，明目张胆地抱着茅草跑进竹林里去了。我费尽口舌也喝止不住，回到家后拄着拐杖独自叹息。\r\n不久后风停了天空上的云像墨一样黑，秋季的天空阴沉迷蒙渐渐黑了下来。布质的被子盖了多年又冷又硬像铁板似的，孩子睡相不好把被子蹬破了。如遇下雨整个屋子没有一点儿干燥的地方，雨点像下垂的麻线一样不停地往下漏。自从安史之乱后我的睡眠时间就很少了，长夜漫漫屋子潮湿不干如何才能挨到天亮？\r\n如何能得到千万间宽敞的大屋，普遍地庇覆天底下贫寒的读书人让他们喜笑颜开，房屋遇到风雨也不为所动安稳得像山一样。唉！什么时候眼前出现这样高耸的房屋，到那时即使我的茅屋被秋风吹破自己受冻而死也心甘情愿！', '秋高：秋深。怒号（háo）：大声吼叫。\r\n三重（chóng）茅：几层茅草。三，泛指多。\r\n挂罥（juàn）：挂着，挂住。罥，挂。长（cháng）：高。\r\n塘坳（ào）：低洼积水的地方（即池塘）。塘，一作”堂“。坳，水边低地。\r\n忍能对面为盗贼：竟狠心这样当面做“贼”。忍能，狠心。对面，当面。为，做。\r\n入竹去：进入竹林。\r\n呼不得：喝止不住。\r\n俄顷（qǐng）：不久，一会儿，顷刻之间。\r\n秋天漠漠向昏黑（古音念hè）：指秋季的天空阴沉迷蒙，渐渐黑了下来。\r\n布衾（qīn）：布质的被子。衾，被子。\r\n恶卧：睡相不好。裂：使动用法，使……裂。\r\n屋漏：根据《辞源》释义，指房子西北角，古人在此开天窗，阳光便从此处照射进来。“床头屋漏”，泛指整个屋子。\r\n雨脚如麻：形容雨点不间断，像下垂的麻线一样密集。雨脚，雨点。\r\n丧（sāng）乱：战乱，指安史之乱。\r\n沾湿：潮湿不干。何由彻：如何才能挨到天亮。彻，彻晓。\r\n安得：如何能得到。广厦（shà）：宽敞的大屋。\r\n大庇（bì）：全部遮盖、掩护起来。庇，遮盖，掩护。寒士：“士”原指士人，即文化人，但此处是泛指贫寒的士人们。俱：都。欢颜：喜笑颜开。\r\n呜呼：书面感叹词，表示叹息，相当于“唉”。\r\n突兀（wù）：高耸的样子，这里用来形容广厦。见（xiàn）：通“现”，出现。\r\n庐：茅屋。亦：一作“意”。足：值得。', '这首诗可分为四节。\r\n　　第一段中共有五句，句句押韵，“号”、“茅”、“郊”、“梢”、“坳”五个开口呼的平声韵脚传来阵阵风声。\r\n\r\n　　“八月秋高风怒号，卷我屋上三重茅。”起势迅猛。“风怒号”三字，音响宏大，犹如秋风咆哮。一个“怒”字，把秋风拟人化，从而使下一句不仅富有动作性，而且富有浓烈的感情色彩——诗人好不容易盖了这座茅屋，刚刚定居下来，秋风却怒吼而来，卷起层层茅草，使得诗人焦急万分。\r\n\r\n　　“茅飞渡江洒江郊”的“飞”字紧承上句的“卷”字，“卷”起的茅草没有落在屋旁，却随风“飞”走，“飞”过江去，然后分散地、雨点似地“洒”在“江郊”：“高者挂罥长林梢”，很难弄下来；“下者飘转沉塘坳”，也很难收回来。“卷”、“飞”、“渡”、“洒”、“挂罥”、“飘转”，一个接一个的动态不仅组成一幅幅鲜明的图画，而且紧紧地牵动诗人的视线，拨动诗人的心弦。\r\n\r\n　　诗人的高明之处在于他并没有抽象地抒情达意，而是寓情意于客观描写之中。这几句诗所表现的场景是：一个衣衫单薄、破旧的干瘦老人拄着拐杖，立在屋外，眼巴巴地望着怒吼的秋风把他屋上的茅草一层又一层地卷了起来，吹过江去，稀里哗啦地洒在江郊的各处。他对大风破屋的焦灼和怨愤之情，不能不激起读者心灵上的共鸣。\r\n\r\n　　第二段中共有五句，这是前一节的发展，也是对前一节的补充。\r\n\r\n　　前节写“洒江郊”的茅草无法收回，除此以外，还有落在平地上可以收回的茅草，但却被“南村群童”抱跑了。“欺我老无力”五字宜着眼，如果诗人不是“老无力”，而是年当壮健有气力，自然不会受这样的欺侮。“忍能对面为盗贼”，意思是，群童竟然忍心在他的眼前做盗贼。但其实，这不过是表现了诗人因“老无力”而受欺侮的愤懑心情而已，决不是真的给“群童”加上“盗贼”的罪名，要告到官府里去办罪。所以，“唇焦口燥呼不得”，也就无可奈何罢了。用诗人杜甫的《又呈吴郎》一诗中的话说，这正是“不为困穷宁有此”，诗人如果不是十分困穷，就不会对大风刮走茅草那么心急如焚；“群童”如果不是因为他十分困穷，也不会冒着狂风抱走那些并不值钱的茅草。这一切，都是结尾的伏线。“安得广厦千万间，大庇天下寒士俱欢颜”的博大胸襟和崇高愿望，正是从“四海困穷”的现实基础上产生而来的。\r\n\r\n　　“归来倚杖自叹息”总收一、二两节。诗人大约是一听到北风狂叫，就担心盖得不够结实的茅屋发生危险，因而就拄杖出门，直到风吹屋破，茅草无法收回，这才无可奈何地走回家中。“倚杖”，当然又与“老无力”照应。“自叹息”中的“自”字，下得很沉痛，诗人如此不幸的遭遇只有他自己在叹息，未引起别人的同情和帮助，则世风的淡薄，就意在言外了，因而他“叹息”的内容，也就十分深广。当他自己风吹屋破，无处安身，得不到别人的同情和帮助的时候，联想到类似处境的无数穷人。\r\n\r\n　　作者叹息的内容有三：1．自己的苦；2．周围人的苦；3．战乱给人们带来的痛苦。\r\n\r\n　　第三段共八句，写屋破又遭连夜雨的苦况。\r\n\r\n　　“俄顷风定云墨色，秋天漠漠向昏黑”两句，用饱蘸浓墨的大笔渲染出暗淡愁惨的氛围，从而烘托出诗人暗淡愁惨的心境，而密集的雨点即将从漠漠的秋空洒向地面，已在预料之中。\r\n\r\n　　“布衾多年冷似铁，娇儿恶卧踏里裂”两句，没有穷困生活体验的作者是写不出来的。值得注意的是这不仅是写布被又旧又破，而是为下文写屋破漏雨蓄势。成都的八月，天气并不“冷”，正由于“床头屋漏无干处，雨脚如麻未断绝”，所以才感到冷。\r\n\r\n　　“自经丧乱少睡眠，长夜沾湿何由彻”两句，一纵一收。一纵，从眼前的处境扩展到安史之乱以来的种种痛苦经历，从风雨飘摇中的茅屋扩展到战乱频繁、残破不堪的国家；一收，又回到“长夜沾湿”的现实。忧国忧民，加上“长夜沾湿”，诗人自然不能入睡。“长夜”是作者由于自己屋漏因而更觉夜长，还因自己和国家都在风雨飘摇中挣扎而觉得夜长。“何由彻”和前面的“未断绝”照应，表现了诗人既盼雨停，又盼天亮的迫切心情。而这种心情，又是屋破漏雨、布衾似铁的艰苦处境激发出来的。于是诗人由个人的艰苦处境联想到其他人的类似处境，水到渠成，自然而然地过渡到全诗的结尾。\r\n\r\n　　“安得广厦千万间，大庇天下寒士俱欢颜，风雨不动安如山”，前后用七字句，中间用九字句，句句蝉联而下，表现阔大境界和愉快情感的词如“广厦”、“千万间”、“大庇”、“天下”、“欢颜”、“安如山”等等，又声音洪亮，从而构成了铿锵有力的节奏和奔腾前进的气势，恰切地表现了诗人从“床头屋漏无干处”、“长夜沾湿何由彻”的痛苦生活体验中迸发出来的奔放激情和火热希望。这种感情，咏歌不足以表达，所以诗人发出了由衷的感叹：“呜呼！何时眼前突兀见此屋，吾庐独破受冻死亦足！”抒发作者忧国忧民的情感，表现了作者推己及人、舍己为人的高尚品格，诗人的博大胸襟和崇高理想，至此表现得淋漓尽致。\r\n\r\n　　此诗作者抒发的情怀与范仲淹的《岳阳楼记》中“先天下之忧而忧，后天下之乐而乐”抒发的情怀基本一致。也表达了作者关心民间疾苦，忧国忧民的思想感情。\r\n\r\n　　俄国著名文学评论家别林斯基曾说：“任何一个诗人也不能由于他自己和靠描写他自己而显得伟大，不论是描写他本身的痛苦，或者描写他本身的幸福。任何伟大诗人之所以伟大，是因为他们的痛苦和幸福的根子深深地伸进了社会和历史的土壤里，因为他是社会、时代、人类的器官和代表。”杜甫在这首诗里描写了他本身的痛苦，但他不是孤立地、单纯地描写他本身的痛苦，而是通过描写他本身的痛苦来表现“天下寒士”的痛苦，来表现社会的苦难、时代的苦难。他也不仅仅是因为自身的不幸遭遇而哀叹、而失眠、而大声疾呼，在狂风猛雨无情袭击的秋夜，诗人脑海里翻腾的不仅是“吾庐独破”，而且是“天下寒士”的茅屋俱破。杜甫这种炽热的忧国忧民的情感和迫切要求变革黑暗现实的崇高理想，千百年来一直激动读者的心灵，并发生过积极的作用。\r\n\r\n　　这首诗描绘秋夜屋漏、风雨交加的情景，真实的记录了草堂生活的一个片段。末段忽生异境，以切身的体验，推己及人，进一步把自己的困苦丢在一边，设想大庇天下寒士的万间广厦。这种非现实的幻想建立在诗人许身社稷，饥溺为怀的思想基础上；而博大胸怀之表现，则使作品放射出积极的浪漫主义光辉。全诗语言极其质朴而意象峥嵘，略无经营而波澜叠出，盖以流自肺腑，故能扣人心弦。', '这首诗作于唐肃宗上元二年（公元761年）八月。公元760年春天，杜甫求亲告友，在成都浣花溪边盖起了一座茅屋，总算有了一个栖身之所。不料到了公元761年八月，大风破屋，大雨又接踵而至。当时安史之乱尚未平息，诗人感慨万千，写下了这篇脍炙人口的诗篇。', '杜甫（712－770），字子美，自号少陵野老，世称“杜工部”、“杜少陵”等，汉族，河南府巩县（今河南省巩义市）人，唐代伟大的现实主义诗人，杜甫被世人尊为“诗圣”，其诗被称为“诗史”。杜甫与李白合称“李杜”，为了跟另外两位诗人李商隐与杜牧即“小李杜”区别开来，杜甫与李白又合称“大李杜”。他忧国忧民，人格高尚，他的约1400余首诗被保留了下来，诗艺精湛，在中国古典诗歌中备受推崇，影响深远。759-766年间曾居成都，后世有杜甫草堂纪念。', '八月秋高風怒號，\r\n\r\na. During autumn in the eighth month, sky was high and wind was strong.\r\n\r\nb. The eighth month, high autumn, the wind howled in rage,\r\n\r\n\r\n\r\n卷我屋上三重茅。\r\n\r\na. Three layers of reeds on roof were blown off.\r\n\r\nb. it rolled up from my roof three layers of thatch.\r\n\r\n\r\n\r\n茅飛度江灑江郊，\r\n\r\na. Those stems flew across river and scattered on its bank.\r\n\r\nb. The thatch flew crossing the river, and was strewn over the floodplain,\r\n\r\n\r\n\r\n高者掛罥長林梢，\r\n\r\na. High-flying ones got snarled and stuck at long branch-tips.\r\n\r\nb. the high ones caught tangled in the treetops of tall woods,\r\n\r\n\r\n\r\n下者飄轉沈塘坳。\r\n\r\na. Those going down swirled and sank to bottom of ponds.\r\n\r\nb. the low ones whirled around and sank in ponds and puddles.\r\n\r\n\r\n\r\n南村群童欺我老無力，\r\n\r\na. Children from south-side of village bullied the old and frail me.\r\n\r\nb. The gangs of boys of south village took advantage of my age and lack of strength,\r\n\r\n\r\n\r\n忍能對面為盜賊。\r\n\r\na. They were so callous as to rob me in my face.\r\n\r\nb. how could they act as thieves before my very face?\r\n\r\n\r\n\r\n公然抱茅入竹去，\r\n\r\na. Defiantly they took off with handfuls of reeds into a bamboo grove.\r\n\r\nb. Right in public they took armfuls of thatch and went off into the bamboo,\r\n\r\n\r\n\r\n脣焦口燥呼不得。\r\n\r\na. My voice-cracking scream yielded no result.\r\n\r\nb. my lips were parched, my mouth was dry, but my shouts didn’t stop them.\r\n\r\n\r\n\r\n歸來倚杖自歎息，\r\n\r\na. Upon returning home, I sighed while leaning on a cane.\r\n\r\nb. I went back leaning on my cane, sighing to myself.\r\n\r\n\r\n\r\n俄頃風定雲墨色，\r\n\r\na. Moments later, wind quelled and clouds were pitch-black.\r\n\r\nb. In a moment the wind died down and the clouds were the color of ink,\r\n\r\n\r\n\r\n秋天漠漠向昏黑。\r\n\r\na. The gloomy autumn sky got darker as night wore on.\r\n\r\nb. they billowed over the autumn sky growing blacker toward dusk.\r\n\r\n\r\n\r\n布衾多年冷似鐵，\r\n\r\na. In cold temperature, my old cloth blanket was hard as metal.\r\n\r\nb. The cloth covers were years old and as cold as iron,\r\n\r\n\r\n\r\n嬌兒惡臥踏裏裂。\r\n\r\na. Kicks of my restlessly sleeping son caused rips in it.\r\n\r\nb. my darling son slept badly and kicked rips in the lining.\r\n\r\n\r\n\r\n床頭屋漏無乾處，\r\n\r\na. Roof leaked at top of my bed and there wasn’t a dry spot in house.\r\n\r\nb. The roof leaked above the bed, there was no place dry,\r\n\r\n\r\n\r\n雨腳如麻未斷絕。\r\n\r\na. Drizzles, like a downpour of silk threads, had been nonstop.\r\n\r\nb. the raindrops came like threads of hemp, never breaking.\r\n\r\n\r\n\r\n自經喪亂少睡眠，\r\n\r\na. I had little sleep since I witnessed deaths and insurrection.\r\n\r\nb. I have been through death and destruction and had but little sleep,\r\n\r\n\r\n\r\n長夜沾濕何由徹。\r\n\r\na. I asked how I could get through the night when everywhere was soaked.\r\n\r\nb. but how can I last through the soaking of this long night?\r\n\r\n\r\n\r\n安得廣廈千萬間，\r\n\r\na. How could I get a huge mansion with ten million rooms,\r\n\r\nb. If only I could get a great mansion of a million rooms,\r\n\r\n\r\n\r\n大庇天下寒士俱歡顏，\r\n\r\na. to harbor needy scholars in this world and put smiles on their faces?\r\n\r\nb. broadly covering the poor scholars of all the world, all with joyous expressions,\r\n\r\n\r\n\r\n風雨不動安如山。\r\n\r\na. The building would withstand wind and rain like a rock.\r\n\r\nb. unshaken by storms, as stable as a mountain.\r\n\r\n\r\n\r\n嗚呼何時眼前突兀見此屋，\r\n\r\na. My goodness, when could such a house suddenly appear in front of my eyes?\r\n\r\nb. Alas, when will I see such a roof looming before my eyes?—\r\n\r\n\r\n\r\n吾廬獨破受凍死亦足。\r\n\r\na. I’d be thrilled at that moment even if my hut were to collapse and I were to freeze to death.\r\n\r\nb. then I would think it all right if my cottage alone were ruined and I suffered death by freezing.', 'Cabane pour le vent d’automne cassé chanson\r\n\r\nDu fu [dynastie tang]\r\n\r\n\r\n\r\nEn automne d’août, le vent élevé en colère, roulé sur ma maison triple mau. MaoFei DuJiang renversé, jiang élevé Juan longue des forêts, de couler hamiltonii (écrasement logeant.\r\n\r\nLes enfants du village du sud m’ont dit que j’étais faible, et que j’étais capable de résister aux voleurs. Il s’enfonce ouvertement dans le bambou, les lèvres brûlées, la bouche sèche, et il s’en retourne en soupirant, appuyé sur son bâton.\r\n\r\nLe vent russe a brisé les nuages d’ombre, l’indifférence à l’automne est devenue noire. Crier: années semble froid de minerai de fer, JiaoEr mal cabine-couchette présente dans la fissuration. La chambre de chevet fuit sans sec, les pieds de pluie comme le chanvre n’est pas coupé. Après avoir perdu moins de sommeil, longue nuit mouillée ho yuche!\r\n\r\nAnde guangxiamma, le monde entier des frigidens joyeux! La pluie et le vent ne bougent pas. Hoo! Quand vous verrez cette maison à la vue, mon lulu mourra de froid!', 'Хижина разбита из-за осеннего ветра\r\n\r\nдафф\r\nАвгустовский осенний порыв ветра крутит мой дом. MaoFei а прол джанг койот, высочайш веша трубк Juan лин руин, XiaZhe поверн тяжел пруд седл.\r\n\r\nДети из саут вилладж дразнили меня старой беспомощностью и терпеть не могли, когда напротив меня воровали. Открыто обнимает мао в бамбук, скука на губах, возвращение, прислонившись к пруту, вздыхает.\r\n\r\nВетер ога омрачает тучи, а осенью пустыня уходит в темноту. Холмы были холодными, как железо, хрупкими и потрескавшимися внутри. Из изголовья ничего не вытекает, и ноги дождей, как онемевшие. Меньше сна во время погрома, больше влаги в ночи!\r\n\r\nВо дворце, в тысячах комнат, под покровом скромной обители мира! Ветер и дождь не двигаются, как горы. Ура! Когда я впервые увидел эту комнату, я понял, что она умерла от холода и холода одна!', '茅屋は秋風に歌を砕く\r\n\r\n杜甫〔唐代〕\r\n\r\n\r\n\r\n八月秋に高き風の怒号、わが屋の三重茅を巻く。茅飛は江を渡って江郊にこぼれ、高い者は両輪の長い林の梢を掛け、下の者は飄々と廻って池襞を沈める。\r\n\r\n南村群の童は私を欺していつも力がなくて、我慢して向うを盗賊にすることができます。公然と茅を抱いて竹に入り、唇が焦げて口が渇いて呼べず、帰ってきて杖に倚り嘆息した。\r\n\r\nやがて風定云墨色、秋は漠として暗き。布衾は何年も寒くて鉄のようで、嬌児悪臥踏の里は裂けます。枕元には乾き所がなく、雨脚がしびれていた。乱を失って眠ることが少なくて、長い夜にぬれて何由徹!\r\n\r\n広厦千万間を安得して、天下の寒士倶歓顔をおおう!風雨動かず安山の如し。嗚呼!いつか目の前に唐突にこの家を見たら、凍死してもいい。', '가을 바람에 초가집이 깨져 노래 부르네\r\n\r\n두보 (唐代)\r\n\r\n\r\n\r\n팔월의 가을 바람이 노호하네, 우리 집 지붕에 띠 삼겹 말아 올리네.모비가 강을 건너서 강 교외에 뿌릴 때, 높게는 긴 숲 끝에 걸었고, 낮게는 늪 평지에 떠돌아다니다.\r\n\r\n남촌의 꼬마들이 늙어서 힘없는 나를 괴롭히는데, 참을만하면 맞은편에서 도둑 취급을 한다.공공연히 띠를 안고 대나무 밭에 들어가서는, 입술이 타서 목이 마르다고 부르짖지 못하고, 돌아와 지팡이에 기대어 혼자 탄식하네. (罗贯道 「 三国演义 」)\r\n\r\n잠깐 바람이 구름을 가라앉히고 먹빛 구름을 가라앉히니 가을은 아득히 어두컴컴하게 되어 간다.천으로 된 이불은 여러 해 동안 쇠처럼 차가웠고, 애교 있는 자식은 누우면 밟아도 찢어지네.침대 머리맡에 지붕이 새고 마른 곳이 없어, 빗발이 거슬거슬하다.스스로 초경을 겪어 잠을 적게 자다니, 긴 밤을 적실 까닭이 무엇이랴!\r\n\r\n어떻게 하면 수많은 집들을 마련하여 세상의 가난한 사람들의 얼굴이 활짝 펴지게 할 수 있을까!비바람도 산처럼 흔들리지 않다.아휴!언제이 집이 눈앞에 불쑥 보일까, 우리 집 홀로 얼어죽어도!');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `occupation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `brief_introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `love` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `funs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `focus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangfei', 'img1', 'lalala', 'soldier', '男', '我最帅', '666', '666', '666');
INSERT INTO `user` VALUES (2, 'guanyu', 'img2', 'heiheihei', 'soldier', '男', '我最牛', '999', '999', '999');
INSERT INTO `user` VALUES (3, 'liubei', 'img3', 'hahaha', 'soldier', '男', '我最大', '1000', '1000', '1000');

SET FOREIGN_KEY_CHECKS = 1;
