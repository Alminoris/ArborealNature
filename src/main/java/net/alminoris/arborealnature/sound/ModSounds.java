package net.alminoris.arborealnature.sound;

import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds
{
    public static final SoundEvent SOUND_SQUIRREL_AMBIENT = registerSoundEvent("sound_squirrel_ambient");
    public static final SoundEvent SOUND_SQUIRREL_HURT = registerSoundEvent("sound_squirrel_hurt");
    public static final SoundEvent SOUND_SQUIRREL_DEATH = registerSoundEvent("sound_squirrel_death");

    public static final SoundEvent SOUND_WOOD_MOUSE_AMBIENT = registerSoundEvent("sound_wood_mouse_ambient");
    public static final SoundEvent SOUND_WOOD_MOUSE_HURT = registerSoundEvent("sound_wood_mouse_hurt");
    public static final SoundEvent SOUND_WOOD_MOUSE_DEATH = registerSoundEvent("sound_wood_mouse_death");

    public static final SoundEvent SOUND_FIGEATER_BEETLE_AMBIENT = registerSoundEvent("sound_figeater_beetle_ambient");
    public static final SoundEvent SOUND_FIGEATER_BEETLE_HURT = registerSoundEvent("sound_figeater_beetle_hurt");
    public static final SoundEvent SOUND_FIGEATER_BEETLE_DEATH = registerSoundEvent("sound_figeater_beetle_death");

    public static final SoundEvent SOUND_ORCHID_MANTIS_AMBIENT = registerSoundEvent("sound_orchid_mantis_ambient");
    public static final SoundEvent SOUND_ORCHID_MANTIS_HURT = registerSoundEvent("sound_orchid_mantis_hurt");
    public static final SoundEvent SOUND_ORCHID_MANTIS_DEATH = registerSoundEvent("sound_orchid_mantis_death");

    public static final SoundEvent SOUND_MOOSE_AMBIENT = registerSoundEvent("sound_moose_ambient");
    public static final SoundEvent SOUND_MOOSE_HURT = registerSoundEvent("sound_moose_hurt");
    public static final SoundEvent SOUND_MOOSE_DEATH = registerSoundEvent("sound_moose_death");

    public static final SoundEvent SOUND_LYNX_AMBIENT = registerSoundEvent("sound_lynx_ambient");
    public static final SoundEvent SOUND_LYNX_GROWL = registerSoundEvent("sound_lynx_growl");
    public static final SoundEvent SOUND_LYNX_WHINE = registerSoundEvent("sound_lynx_whine");
    public static final SoundEvent SOUND_LYNX_HURT = registerSoundEvent("sound_lynx_hurt");
    public static final SoundEvent SOUND_LYNX_DEATH = registerSoundEvent("sound_lynx_death");

    public static final SoundEvent SOUND_CARIBOU_AMBIENT = registerSoundEvent("sound_caribou_ambient");
    public static final SoundEvent SOUND_CARIBOU_ANGRY = registerSoundEvent("sound_caribou_angry");
    public static final SoundEvent SOUND_CARIBOU_HURT = registerSoundEvent("sound_caribou_hurt");
    public static final SoundEvent SOUND_CARIBOU_DEATH = registerSoundEvent("sound_caribou_death");

    public static final SoundEvent SOUND_WOLVERINE_AMBIENT = registerSoundEvent("sound_wolverine_ambient");
    public static final SoundEvent SOUND_WOLVERINE_AMBIENT_PLUS = registerSoundEvent("sound_wolverine_ambient_plus");
    public static final SoundEvent SOUND_WOLVERINE_HURT = registerSoundEvent("sound_wolverine_hurt");
    public static final SoundEvent SOUND_WOLVERINE_DEATH = registerSoundEvent("sound_wolverine_death");

    public static final SoundEvent BLOCK_PINK_PETALS_BREAK = registerSoundEvent("block_pink_petals_break");
    public static final SoundEvent BLOCK_PINK_PETALS_STEP = registerSoundEvent("block_pink_petals_step");
    public static final SoundEvent BLOCK_PINK_PETALS_PLACE = registerSoundEvent("block_pink_petals_place");
    public static final SoundEvent BLOCK_PINK_PETALS_HIT = registerSoundEvent("block_pink_petals_hit");
    public static final SoundEvent BLOCK_PINK_PETALS_FALL = registerSoundEvent("block_pink_petals_fall");

    public static final BlockSoundGroup PINK_PETALS_SOUND_GROUP = new BlockSoundGroup(1.0f, 1.0f,
            BLOCK_PINK_PETALS_BREAK,
            BLOCK_PINK_PETALS_STEP,
            BLOCK_PINK_PETALS_PLACE,
            BLOCK_PINK_PETALS_HIT,
            BLOCK_PINK_PETALS_FALL
    );

    private static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = Identifier.of(ArborealNature.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds()
    {

    }
}
