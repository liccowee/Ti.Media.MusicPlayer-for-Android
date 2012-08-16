/* C++ code produced by gperf version 3.0.3 */
/* Command-line: gperf -L C++ -E -t /Users/activate/Desktop/Musicplayer/build/generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/Users/activate/Desktop/Musicplayer/build/generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.activate.musicplayer.MusicPlayer.h"


#line 13 "/Users/activate/Desktop/Musicplayer/build/generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 1, duplicates = 0 */

class MusicplayerBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
MusicplayerBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
MusicplayerBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 1,
      MIN_WORD_LENGTH = 36,
      MAX_WORD_LENGTH = 36,
      MIN_HASH_VALUE = 36,
      MAX_HASH_VALUE = 36
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
#line 15 "/Users/activate/Desktop/Musicplayer/build/generated/KrollGeneratedBindings.gperf"
      {"com.activate.musicplayer.MusicPlayer", ::com::activate::musicplayer::MusicPlayer::bindProxy, ::com::activate::musicplayer::MusicPlayer::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 16 "/Users/activate/Desktop/Musicplayer/build/generated/KrollGeneratedBindings.gperf"

