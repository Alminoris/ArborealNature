package net.alminoris.arborealnature.sound;

import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

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

    private static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = Identifier.of(ArborealNature.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds()
    {

    }
}
